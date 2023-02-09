# Simple Backend Clojure App

Used for demonstrative purposes during a live code session at Oulu University, Software Engineering Research course.

Implements a small backend software, with a mock database and couple of API routes.

## Installation

Clone the repo.

Install OpenJDK for Java https://adoptium.net/

Install Leiningen for running Clojure programs simply https://leiningen.org/

## Usage

In the root directory (the one with `project.clj`) run `lein repl` to launch the REPL.

To run the backend, run the command `(start)` in the REPL, which starts and mounts the Jetty web server.

The server runs on `localhost:8880` with the API at `localhost:8880/api/**`, there's a Swagger interface available.

The app uses a few libraries, namely Mount Lite for componentization, Ring & Reitit for http route handling, Muuntaja for data mangling.

https://github.com/ring-clojure/ring

https://github.com/aroemers/mount-lite

https://github.com/metosin/reitit

https://github.com/metosin/muuntaja

## License

You can use this any way you want.
