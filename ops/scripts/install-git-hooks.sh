#!/bin/bash

# Copy pre-commit hook script
cp -f ./ops/scripts/pre-commit.sh .git/hooks/pre-commit
chmod +x .git/hooks/*

# Copy pre-commit hook script
cp -f ./ops/scripts/pre-push.sh .git/hooks/pre-push
chmod +x .git/hooks/*
