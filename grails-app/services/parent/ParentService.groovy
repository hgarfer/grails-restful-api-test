package parent

import grails.transaction.Transactional

@Transactional
class ParentService {

    def list(Map params) {
        params.max = params.max ?: 100
        Parent.list(params)
    }


    def count(Map params) {
        Parent.count()
    }


    def show(Map params) {
        Parent.findById(params.id as Long)
    }


    def create(Map content, Map params) {
        new Parent(content).save flush: true, failOnError: true
    }


    def update(def id, Map content, Map params) {
        def object = Parent.findById(id as Long)
        object.properties = content
        object.save flush: true, failOnError: true
    }


    void delete(def id, Map content, Map params) {
        def object = Parent.findById(id as Long)
        if (object) {
            object.delete(params)
        }
    }
}
