(defproject facjure/mesh "0.5.0-SNAPSHOT"  :description "A toolkit for responsive grids and typography"  :url "https://github.com/facjure/mesh"  :license {:name "Eclipse Public License" :url "http://www.eclipse.org/legal/epl-v10.html"}  :scm {:name "git" :url "https://github.com/facjure/mesh"}  :min-lein-version "2.6.0"  :jvm-opts ["-Xms512m" "-server"]  :global-vars {*warn-on-reflection* false *assert* false}  :dependencies [[org.clojure/clojure "1.8.0"]                 [org.clojure/clojurescript "1.8.51"]                 [com.gfredericks/cljs-numbers "0.1.2"]                 [garden "1.3.2"]]  :node-dependencies [[autoprefixer "6.3.6"]]  :source-paths ["src" "target/classes"]  :clean-targets ^{:protect false} ["resources/public/js" "target/classes"]  :cljsbuild {:builds              [{:id "dev"                :source-paths ["examples" "env/dev"]                :compiler {:output-to "resources/public/js/mesh.js"                           :output-dir "resources/public/js/out"                           :main dev.repl                           :asset-path "js/out"                           :optimizations :none                           :cache-analysis true                           :source-map true}}               {:id "prod"                        :source-paths ["src"]                        :compiler {:output-to "dist/mesh.min.js"                                   :optimizations :advanced                                   :pretty-print false}}]}  :garden {:builds           [{:id "typography"             :source-paths ["src" "examples"]             :stylesheet typography.styles/index             :compiler {:output-to "resources/public/css/typography.css"                        :pretty-print true}}            {:id "grids"             :source-paths ["src" "examples"]             :stylesheet grids.styles/index             :compiler {:output-to "resources/public/css/grids.css"                        :pretty-print true}}]}  :profiles {:dev             {:dependencies [[org.omcljs/om "0.9.0"]                             [com.cemerick/piggieback "0.2.1"]                             [figwheel "0.5.1"]                             [figwheel-sidecar "0.5.1"]                             [brutha "0.2.0"]                             [sablono "0.3.4"]]              :figwheel {:http-server-root "public"                         :server-port 3449                         :nrepl-port 7888                         :css-dirs ["resources/public/css"]                         :open-file-command "emacsclient"}}}  :plugins [[lein-cljsbuild "1.1.3"]            [lein-figwheel "0.5.1"]            [lein-garden "0.2.6"]            [lein-npm "0.6.2"]            [lein-pdo "0.1.1"]]  :aliases {"clean-all"  ["pdo" "clean," "garden" "clean"]            "dev" ["pdo" "garden" "auto," "figwheel"]            "release" ["pdo" "clean," "cljsbuild" "once" "prod"]})