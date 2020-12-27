import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.feature._
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.PCA
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.sql.SparkSession

object spark_svm {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "F:\\hadoop-common-2.2.0-bin")
    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

    //    创建SparkSession
    val spark = SparkSession
      .builder
      .appName("svm_example")
      .master("local[2]")
      .getOrCreate()

    //    加载数据
    val data = spark.read.format("libsvm").load("./data/sample_libsvm_data.txt")
    data.show(5)

    //    数据归一化
    val scaler = new StandardScaler()
      .setInputCol("features")
      .setOutputCol("scaledfeatures")
      .setWithMean(true)
      .setWithStd(true)
    val scalerdata = scaler.fit(data)
    val scaleddata = scalerdata.transform(data).select("label","scaledfeatures").toDF("label","features")
    data.show(5)

    //    PCA降维
    val pca = new PCA()
      .setInputCol("features")
      .setOutputCol("pcafeatures")
      .setK(5)
      .fit(scaleddata)
    val pcadata = pca.transform(scaleddata).select("label","pcafeatures").toDF("label","features")
    data.show(5)

    //    划分数据集
    val Array(trainData, testData) = pcadata.randomSplit(Array(0.5, 0.5), seed = 20)
    trainData.count()

    //    创建svm
    val lsvc = new LinearSVC()
      .setMaxIter(10)
      .setRegParam(0.1)

    //    创建pipeline
    val pipeline = new Pipeline()
      .setStages(Array(scaler, pca, lsvc))
    //    训练svc
    //    val lsvcmodel = lsvc.fit(trainData)
    val lsvcmodel = pipeline.fit(trainData)

    //    验证精度
    val res = lsvcmodel.transform(testData).select("prediction","label")
    val evaluator = new MulticlassClassificationEvaluator()
      .setLabelCol("label")
      .setPredictionCol("prediction")
      .setMetricName("accuracy")

    val accuracy = evaluator.evaluate(res)
    println(s"Accuracy = ${accuracy}")

    spark.stop()

  }
}


