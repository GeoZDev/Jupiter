#!/bin/sh
DIR="$(cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd)"
cd "$DIR"

###############
## �ċN���̐ݒ� #
###############

DO_LOOP="false"

###############################
# �����艺�̕ҏW�͂����߂��܂���! #
###############################

clear

NUKKIT_FILE=""

if [ "$NUKKIT_FILE" == "" ]; then
	if [ -f ./nukkit*.jar ]; then
		NUKKIT_FILE="./nukkit-1.0-SNAPSHOT.jar"
	else
		echo "[ERROR] Nukkit JAR ��������܂���ł���!"
		exit 1
	fi
fi

LOOPS=0

while [ "$LOOPS" -eq 0 ] || [ "$DO_LOOP" == "true" ]; do
	if [ "$DO_LOOP" == "true" ]; then
		java -jar "$NUKKIT_FILE" $@
	else
		exec java -jar "$NUKKIT_FILE" $@
	fi
	((LOOPS++))
done

if [ ${LOOPS} -gt 1 ]; then
	echo "[INFO] $LOOPS ��ڂ̍ċN���ł��B"
fi