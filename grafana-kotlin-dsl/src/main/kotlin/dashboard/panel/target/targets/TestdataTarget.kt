package dashboard.panel.target.targets

import dashboard.panel.target.Target
import datasource.DataSourceRef

class TestdataTarget(): Target()  {
    constructor(refId: String): this() {
        refId(refId)
    }

    fun dataSource(uid: String) = dataSource(DataSourceRef.Type.TestdataDatasource, uid)

    fun alias(alias: String) = field("alias", alias)

    fun drop(drop: Int) = field("drop",drop)

    fun labels(labels: String) = field("labels",labels)

    fun max(max: Double) = field("max",max)
    fun min(min: Double) = field("min",min)
    fun noise(noise: Int) = field("noise",noise)
    fun scenarioId(scenarioId: String) = field("scenarioId",scenarioId)
    fun seriesCount(seriesCount: Int) = field("seriesCount",seriesCount)
    fun spread(spread: Int) = field("spread",spread)
    fun startValue(startValue: Double) = field("startValue",startValue)
}