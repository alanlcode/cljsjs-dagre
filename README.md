# alanlcode/dagre

ClojureScript wrapper for [dagre](https://github.com/cpettitt/dagre)
[](dependency)
```clojure
[cljsjs/dagre "0.7.5-fork-0-SNAPSHOT"] ;; latest release
```
[](dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.dagre]))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
