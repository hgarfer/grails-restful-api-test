import parent.Parent
import son.Son
import wife.Wife

class BootStrap {

    def init = { servletContext ->


        Wife wife = new Wife(wifeName: 'wife').save flush: true, failOnError: true

        Parent parent = new Parent(name: 'parent', wife: wife)

        parent.sons = []
        [0..10].each{
//            Son son = new Son(sonName: 'son' +it).save flush: true, failOnError: true
            parent.sons.add(new Son(sonName: 'son' +it))
        }

        parent.save flush: true, failOnError: true


    }
    def destroy = {
    }
}
