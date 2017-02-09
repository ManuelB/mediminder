#!/usr/bin/jjs -fv
var System = Java.type("java.lang.System");
var cmd = "mvn package";
$EXEC(cmd, System.in, System.out, System.err);
cmd = "docker build -t incentergy/mediminder .";
$EXEC(cmd, System.in, System.out, System.err);
