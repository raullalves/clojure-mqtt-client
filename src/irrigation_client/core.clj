(ns irrigation-client.core
  (:gen-class)
  (:require [clojurewerkz.machine-head.client :as mh]))
(defn -main
  [& args]
  (let [conn (mh/connect "tcp://127.0.0.1:1883")]
    (mh/subscribe conn {"hackaton" 0} (fn [^String topic _ ^bytes payload]
                                   (println (String. payload "UTF-8"))
                                   (mh/disconnect conn)
                                   (System/exit 0)))
    (mh/publish conn "hackaton" "longitude, latitude")))
