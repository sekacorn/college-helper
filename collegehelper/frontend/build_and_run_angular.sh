#!/bin/bash

# Script to install dependencies, build, and run the Angular app.
# Place this script in your frontend folder.
# Usage: bash build_and_run_angular.sh

# Check for package.json
if [ ! -f "package.json" ]; then
  echo "ERROR: Run this script from your Angular frontend project root!"
  exit 1
fi

echo "------------------------------"
echo " Installing dependencies...    "
echo "------------------------------"
npm install

if [ $? -ne 0 ]; then
  echo "npm install failed! Check your Node.js/npm setup."
  exit 2
fi

echo
echo "------------------------------"
echo " Building Angular app...       "
echo "------------------------------"
npm run build

if [ $? -ne 0 ]; then
  echo "Angular build failed!"
  exit 3
fi

echo
echo "------------------------------"
echo " Starting Angular server...    "
echo "------------------------------"
npm start

# If your package.json uses "ng serve" as the start script, this will run the dev server
# Otherwise, you may want to run: npx ng serve --open
