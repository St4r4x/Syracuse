javac Syracuse.java
touch altmax$1$2.txt
touch dureevol$1$2.txt
sudo chmod u+rwx altmax$1$2.txt
sudo chmod u+rwx dureevol$1$2.txt
for ((i=$1; i<=$2; i++))
do
    java Syracuse $i
    altmax=$(tail -n 2 f$i.dat | head -n 1 | cut -d '=' -f2) 
    echo $altmax >> altmax$1$2.txt
    dureevol=$(tail -n1 f$i.dat | cut -d '=' -f2) 
    echo $dureevol >> dureevol$1$2.txt
    rm f$i.dat
done