(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.5-pre")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/dagre
        :version     +version+
        :description "dagre - Graph layout for JavaScript"
        :url         "https://github.com/cpettitt/dagre"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (sift :add-resource #{"/Users/aleung/proj/forks/dagre/dist/"})
    (sift :move {#"dagre\.js"          "cljsjs/dagre/development/dagre.inc.js"
                 #"dagre\.min\.js"     "cljsjs/dagre/production/dagre.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.dagre")))
