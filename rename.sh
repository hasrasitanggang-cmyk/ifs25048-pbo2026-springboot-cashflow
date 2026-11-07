#!/bin/bash
# Pemakaian: ./rename.sh abdullah_ubaid
set -e
U="$1"; [ -z "$U" ] && { echo "Isi username: ./rename.sh <username>"; exit 1; }
OLD="usernamepbo2026springbootcashflow"; NEW="${U}pbo2026springbootcashflow"
grep -rl "$OLD" src | xargs sed -i "s/$OLD/$NEW/g"
for d in src/main/java/org/delcom src/test/java/org/delcom; do mv "$d/$OLD" "$d/$NEW"; done
echo "Selesai. Package: org.delcom.$NEW"
