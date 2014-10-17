package parent

import son.Son
import wife.Wife

class Parent {
    String name
    Wife wife

    static hasMany = [sons: Son]


    static constraints = {
    }
}
