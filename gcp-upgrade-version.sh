#bin!/bin/bash
VERSION_FILE="gcp-version.txt"
version=$(cat "$VERSION_FILE")
nouvelle_version=$((version + 1))
echo "$nouvelle_version" > "$VERSION_FILE"