#!/bin/bash

PROJECT_DIR=$(git rev-parse --show-toplevel)
LOCAL_HOOK_DIR=$PROJECT_DIR/.git/hooks
PROJECT_HOOK_DIR=$PROJECT_DIR/githook/hooks
HOOK_NAMES=$(ls $PROJECT_HOOK_DIR)

mkdir -p $LOCAL_HOOK_DIR

for hook in $HOOK_NAMES; do
    # Create a symbolic link in the local hook directory with the project's hook file.
    ln -s -f $PROJECT_HOOK_DIR/$hook $LOCAL_HOOK_DIR/$hook
done
