#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

if [ -n "$DEBUG" ] ; then
    echo "-$BASH_SOURCE: unsetting DEBUG; not supported."
fi

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
PRG="$0"
while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    expr "$link" : '/.*' > /dev/null
    if [ $id -eq 0 ] ; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`/"$link"
    fi
done

saved="`pwd`"
cd "`dirname \"$PRG\"`" >/dev/null
APP_HOME="`pwd -P`"
cd "$saved" >/dev/null

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

# Use the maximum available, or set MAX_FD to the maximum
if [ -n "$MAX_FD" ] ; then
    MAX_FD_limit=`ulimit -H -n`
    if [ $? -eq 0 ] ; then
        if [ -n "$CYGWIN" -o -n "$MSYSTEM" -o -n "$MINGW" ] ; then
            MAX_FD_limit=maximum
        fi
        ulimit -n $MAX_FD_limit
        if [ $? -ne 0 ] ; then
            echo "Could not set maximum file descriptor limit: $MAX_FD_limit" >&2
        fi
    else
        echo "Could not set maximum file descriptor limit (cannot query limit)." >&2
    fi
fi

# Setup the command run
exec gradle "$@"
