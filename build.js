#!/usr/bin/jjs -fv
var System = Java.type("java.lang.System");
var cmd = "mvn package";
$EXEC(cmd, System.in, System.out, System.err);
cmd = "docker build -t incentergy/mediminder .";
$EXEC(cmd, System.in, System.out, System.err);
// docker tag <SNASHOTID> 765415433338.dkr.ecr.eu-central-1.amazonaws.com/incentergy
// docker push 765415433338.dkr.ecr.eu-central-1.amazonaws.com/incentergy
