(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.5-fork")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'alanlcode/dagre
        :version     +version+
        :description "ClojureScript wrapper for dagre."
        :url         "https://github.com/alanlcode/cljsjs-dagre"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/alanlcode/cljsjs-dagre"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/alanlcode/dagre/releases/download/v%s/dagre-%s.zip" +lib-version+ +lib-version+)
              :unzip true)
    (sift :move {#"dagre-([\d\.]*-fork)/dist/dagre\.js"          "alanlcode/dagre/development/dagre.inc.js"
                 #"dagre-([\d\.]*-fork)/dist/dagre\.min\.js"     "alanlcode/dagre/production/dagre.min.inc.js"})
    (sift :include #{#"^alanlcode"})
    (deps-cljs :name "alanlcode.dagre")
    (pom)
    (jar)))
