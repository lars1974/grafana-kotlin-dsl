package dashboard.panel.common.fieldconfig.defaults.mappings

import AbstractGrafanaArray

class Mappings : AbstractGrafanaArray() {

    var index = 0
    fun mapping(mapping: Mapping.() -> Unit) = add(Mapping().apply(mapping))
    fun range(text: String, from: Double, to: Double) {
        mapping {
            type(Mapping.Type.Range)
            options {
                result {
                    index(index++)
                    text(text)
                }
                from(from)
                to(to)
            }
        }
    }

    fun special(text: String, match: Options.Match) {
        mapping {
            type(Mapping.Type.Special)
            options {
                result {
                    index(index++)
                    text(text)
                }
                match(match)
            }
        }
    }

    fun regex(text: String, pattern: String) {
        mapping {
            type(Mapping.Type.Special)
            options {
                result {
                    index(index++)
                    text(text)
                }
                pattern(pattern)
            }
        }

    }
}