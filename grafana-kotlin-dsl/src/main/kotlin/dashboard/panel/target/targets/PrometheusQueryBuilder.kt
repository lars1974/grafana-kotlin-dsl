package dashboard.panel.target.targets

import AbstractGrafanaObject

class PrometheusQueryBuilder: AbstractGrafanaObject(){
    var q = ""

    fun metric(metric: String, tags: String) = "$metric$tags".also { q = it }

    fun filters(vararg tags: String) = tags.joinToString(",","{","}").also { q = it }
    fun gth(tag: String, value: String) = """$tag > "$value"""".also { q = it }
    fun lth(tag: String, value: String) = """$tag < "$value"""".also { q = it }
    fun eq(tag: String, value: String) = """$tag = "$value"""".also { q = it }
    fun neq(tag: String, value: String) = """$tag != "$value"""".also { q = it }
    fun match(tag: String, value: String) = """$tag =~ "$value"""".also { q = it }
    fun nmatch(tag: String, value: String) = """$tag !~ "$value"""".also { q = it }

    fun rate(function:String, range: String = "2m") = "rate ( $function [$range] )".also { q = it }
    fun increase(function:String, range: String = "2m") = "increase ( $function [$range] )".also { q = it }
    fun sumOverTime(function:String, range: String = "\$__interval") = "sum_over_time ( $function [$range] )".also { q = it }
    fun sum(function:String) = "sum ( $function )".also { q = it }
    fun sumBy(function:String, by: String) = "sum by ($by) ( $function )".also { q = it }
    fun sumBy(function:String, vararg by: String) = sumBy(function, by.joinToString(","))
    fun avg(function:String) = "avg ( $function )".also { q = it }

}