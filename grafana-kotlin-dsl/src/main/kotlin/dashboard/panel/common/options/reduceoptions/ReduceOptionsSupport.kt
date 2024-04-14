package dashboard.panel.common.options.reduceoptions

import JacksonSupport


interface ReduceOptionsSupport: JacksonSupport {
    fun reduceOptions(reduceOptions: ReduceOptions.() -> Unit) = obj("reduceOptions", ReduceOptions().apply(reduceOptions))
}