(defproject ser "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [functionalbytes/mount-lite "2.3.0"]
                 [ring "1.9.6"]
                 [clj-http "3.12.3"]
                 [metosin/muuntaja "0.6.8"]
                 [metosin/reitit "0.5.18"]]
  :main ^:skip-aot ser.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
