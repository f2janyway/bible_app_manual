#!/bin/bash

# Define source and destination directories
SOURCE_DIR="composeApp/build/dist/wasmJs/productionExecutable"
DEST_DIR="docs"

# Check if source directory exists
if [ ! -d "$SOURCE_DIR" ]; then
    echo "Source directory $SOURCE_DIR does not exist. Exiting."
    exit 1
fi

# Check if destination directory exists
if [ ! -d "$DEST_DIR" ]; then
    echo "Destination directory $DEST_DIR does not exist. Creating it."
    mkdir -p "$DEST_DIR"
fi

# Copy all files from source to destination
cp -r "$SOURCE_DIR"/* "$DEST_DIR"

echo "All files from $SOURCE_DIR have been copied to $DEST_DIR."
