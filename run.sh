JAVA=java
LOCALCLASSPATH=
for item in `ls target/dependency`; do
    LOCALCLASSPATH=target/dependency/$item:$LOCALCLASSPATH
done

#echo $LOCALCLASSPATH

#nice $JAVA  -ea -Xmx2096M -cp target/classes:$LOCALCLASSPATH edu.illinois.cs.cogcomp.sl.SVMLightSeq.MainClass  $*
#nice $JAVA  -ea -Xmx2096M -cp target/classes:$LOCALCLASSPATH edu.illinois.cs.cogcomp.sl.applications.tutorial.MainClass  $*
nice $JAVA  -ea -Xmx2096M -cp target/classes:$LOCALCLASSPATH edu.illinois.cs.cogcomp.sl.applications.ranking.RankTrainer  $*
