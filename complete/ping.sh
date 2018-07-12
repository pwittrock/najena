#!/usr/bin/env bash

while [  true ]; do
    # Canary
    echo "Canary"
    curl http://35.238.230.29 # Foo
    curl http://35.238.118.113 # Bar

    # USWEST
    echo "USWEST"
    curl http://35.197.103.55 # Foo
    curl http://35.197.46.137 # Bar

    # USEAST
    echo "USEAST"
    curl http://104.196.12.217 # Foo
    curl http://35.196.5.106 # Bar
done

