#!/bin/bash

PROJECT_DIR=$(git rev-parse --show-toplevel)
LOCAL_HOOK_DIR=$PROJECT_DIR/.git/hooks
PROJECT_HOOK_DIR=$PROJECT_DIR/githook/hooks
HOOK_NAMES=$(ls $PROJECT_HOOK_DIR)

for hook in $HOOK_NAMES; do
    # Remove the created hook file.
    rm -rf $LOCAL_HOOK_DIR/$hook
done