
    import groovy.json.JsonSlurper

    def old = '{"group1" : "1", "group2": "2", "group3" : "3", "group4" : "4", "group5" : "5",  "group9" : "100"}'
    def neww = '{"group1" : "1.1", "group2": "2" ,"group4" : "4", "group5" : "5.2",  "group6" : "6"}'


    def old_1 = new JsonSlurper().parseText(old)
    def neww_1 = new JsonSlurper().parseText(neww)


    def old_slurp = groovy.json.JsonOutput.toJson(old_1 - neww_1)
    def new_slurp = groovy.json.JsonOutput.toJson(old_1 + neww_1)

    def commons_slurp = old_1.plus(neww_1)
    def difference_slurp = old_1.minus(neww_1)
    def remove_slurp = commons_slurp.minus(difference_slurp)

    print '\n' + old_1.minus(neww_1)

    def finallll = old_slurp.minus(new_slurp)

    print '\n' + '\n' + "commons_slurp= "  +commons_slurp
    print '\n' + "difference_slurp= " + difference_slurp
    print '\n' + "remove_slurp= " + remove_slurp

'''
OLD   new     DATABASE = OUTPUT
1     1.1     1.1
2     2       2
3     4       
4     5.2     4
5     6       5.2
              6
10
'''

'''
def old_slurp = groovy.json.JsonOutput.toJson(old_1 - neww_1)
def new_slurp = groovy.json.JsonOutput.toJson(old_1 + neww_1)

def commons_slurp = groovy.json.JsonOutput.toJson(old_1.intersect(neww_1))
def difference_slurp = groovy.json.JsonOutput.toJson(old_1.minus(neww_1))

def remove_slurp = groovy.json.JsonOutput.toJson(new_slurp.minus(difference_slurp))

'''