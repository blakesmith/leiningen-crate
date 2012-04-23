(ns pallet.crate.lein
  (:require [pallet.action.remote-file :as remote-file]))

(def default-install-path "/usr/local/bin")
(def script-url "https://raw.github.com/technomancy/leiningen/stable/bin/lein")

(defn- install-script
  [session install-path]
  (-> session
      (remote-file/remote-file
       (format "%s/lein" install-path)
       :url script-url
       :mode 755)))

(defn lein
  [session & {:keys [install-path]
              :or {install-path default-install-path}
              :as opts}]
  (-> session
      (install-script install-path)))