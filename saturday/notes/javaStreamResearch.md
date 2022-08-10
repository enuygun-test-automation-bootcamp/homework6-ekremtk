# Java Stream

<hr style="border:7px solid darkred">

**➡ ⇒ ⇨ &rarr;** Nedir bu Java Stream?

* Java 8 ile birlikte kullanıma sunulmuş özelliklerin arasında en önemlisi **Stream** olarak gösterilmektedir.
* Stream yapısı bir veri kaynağı etrafında bir sarmalayıcı olarak görev yapar.
    * Bu sayede ilgili veri kaynağı ile çalışmaya, toplu biçimdeki işlemeyi daha kolay ve hızlı bir biçimde olmasına
      olanak sağlar.

```java
// Önceki Java versiyonlarında elemanlarının yaşını bulan bir fonksiyon    
public int sumOfPersonnelAges(List<Personnel> personnelList){
        int ageSum=0;
        for(Personnel personnel:personnelList){
        ageSum+=personnel.getAge();
        }
        System.out.println("Ages sum : "+ageSum);
        return ageSum;
        }
```

```java
// Stream Metodu ile aynı işlemin gerçekleştirilmesi    
public int sumOfPersonnelAges(List<Personnel> personnelList){
        return personnelList.stream().mapToInt(Personnel::getAge).sum();
        }
```

<hr style="border:7px solid rebeccapurple">

## Önemli Noktalar !

* Java I/O'da bulunan stream ile karıştırılmamalıdır.
    * FileInputStream gibi metotlar
    * Bunların konuyla olan ilgisi azdır.


* Veri depolama yapmaz.


* Temel veri kaynağını değiştirmez

<hr style="border:7px solid rebeccapurple">

## Stream İşlemleri

### forEach()

* En basit ve en yaygın kullanılan işlemdir.
* Her bir eleman için sağlanan fonksiyonu çağırarak Stream elemanları üzerinde bir döngü ile çalıştırır.


* **Örnek** (Verilen listedeki elemanların karesini alarak ekrana yazdırma):

```java
List number = Arrays.asList(2,3,4,5);
number.stream().map(x->x*x).forEach(y->System.out.println(y))
```
### map()

* Orijinal Stream'deki (akıştaki) her bir elemana fonksiyon uygulandıktan sonra yeni bir stream üretir.
    * Bu arada üretilen akış farklı bir türde de olabilir.


* **Örnek** (Verilen listedeki elemanların karesini alarak yeni bir liste oluşturma):

```java
List number=Arrays.asList(2, 3, 4, 5);
List square=number.stream().map(x->x*x).collect(Collectors.toList());
```

### filter()

* Orijinal stream'deki ögelerden belirli bir testi geçenleri içeren yeni bir stream üretir.
    * Buradaki test Predicate (Yüklem/Ön Biçimleme Programı) tarafından belirlenir.


* **Örnek** (Verilen Listedeki Elemanlardan S ile başlayanları yeni bir listede belirtme):

```java
List names=Arrays.asList("Reflection", "Collection", "Stream");
List result=names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
```

<hr style="border:10px solid darkseagreen">

## References

1) [A Guide to Java Streams in Java 8: In-Depth Tutorial With Examples](https://stackify.com/streams-guide-java-8/)
2) [Stream In Java](https://www.geeksforgeeks.org/stream-in-java/)
3) [The Java 8 Stream API Tutorial](https://www.baeldung.com/java-8-streams)
4) [Java 8 Stream yapısına nazik bir giriş - 1](https://medium.com/@sinanselimoglu/java-8-stream-yap%C4%B1s%C4%B1na-nazik-bir-giri%C5%9F-f2a5977215c6)
