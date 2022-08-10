# Lesson Notes and Researches

<hr style="border:7px solid darkred">

## Polymorphism

* Kelime anlamı olarak **Çok Biçimlilik** olarak ifade edilir.

* Temel olarak bir nesnenin birbirinden farklı nesneler şeklinde davranmasını sağlamamıza olanak veren yapı olarak açıklanabilir.\
  * Günlük hayatımız ile ilişkilendirmek istersek;
    * Bir erkek; evde çocuk, okulda öğrenci, sokakta arkadaş gibi farklı tanımlamalara sahiptir.
      * Yani aslında aynı kişi farklı davranışlara ve görevlere sahip olmasıdır.

* Avantajları ise:
  * Tek bir değişken ile birden çok veri türü depolanabilir.
  * Program akışında tekrar kullanılacak olan kodlar minimum seviyede tutularak "Clean Code" elde edilir ve kodun okunabilirliği artar.
  * Farklı işlemler arasındaki bağlantı azaltılır.
  * Program içinde eğer bir hata meydana gelirse daha rahat biçimde hata ayıklanabilir ve çözülebilir.

* Kod Örneği:

```java
// animal (Hayvan) Super Sınıfı Oluşturulur
class Animal {
    // animalSound (Hayvan Sesi) adında bir metot oluşturulur.
    // Bütün Hayvanlar ses çıkardığı için bu ortaktır.
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}

// Hayvan Sınıfından türetilen bir Kedi Sınıfı oluşturulur
class Cat extends Animal {
    // Oluşturulan sınıf içine metot yazdırılır
    public void animalSound() {
        System.out.println("The cat says: meow meow");
    }
}

// Benzer uygulama Köpek sınıfı için de uygulanır.
class Dog extends Animal {
    public void animalSound() {
        System.out.println("The dog says: bow wow");
    }
}
```

```java
// Ana sınıf içinde metotlar çağrılır
class Main {
    public static void main(String[] args) {

        // Hayvan/Kedi/Köpek sınıflarından birer nesne oluşturulur
        Animal myAnimal = new Animal();
        Animal myCat = new Cat();
        Animal myDog = new Dog();

        // Her bir nesnenin metotları çağrılır.
        myAnimal.animalSound();
        myCat.animalSound();
        myDog.animalSound();
    }
}
```
> The animal makes a sound\
The cat says: meow meow\
The dog says: bow wow

<hr style="border:7px solid rebeccapurple">

## Assert (Savunmak) ile Verify (Doğrulamak) arasındaki fark

* Assertion çalışması sırasında, assert koşulu çalışması sağlanmadığı zaman test çalışması durdurulur.
  * Kalan testler hiç yapılmadan atlanır ve testin sonucu başarısız olarak döner.
  * Hard Assert ve Soft Assert olmak üzere iki farklı türü mevcuttur.

* Verify çalışması sırasında, koşulların onaylanma durumu oluşmasa bile son test çalışması tamamlana kadar akış yürütülür.
  * Yanlış bir koşul meydana gelse de bir sonraki test adımına geçiş yapılır.
  * Herhangi bir türü yoktur.

* Hard Assertion
  * Koşul sağlanmadığı zaman testin yürütülmesi durdurulur.
  * Assert koşullarını sağlamak için herhangi bir yöntemin çağrılmasına gerek yoktur.
* Soft Assertion
  * Koşul sağlanmasa bile test senaryosu sonuna kadar devam eder.
  * Testin sonundaki sonucu görmek için **assertAll()** komutunun çağrılması gerekir.

<hr style="border:10px solid darkseagreen">

## References

1) [Java Polymorphism](https://www.w3schools.com/java/java_polymorphism.asp)
2) [Java’da Çok Biçimlilik](https://www.kodkampusu.com/javada-cok-bicimlilik-polymorphism/#close)
3) [Java Polymorphism Nedir?](https://emrecelen.com.tr/java-polymorphism-nedir/)
4) [Assert and Verify Methods in Selenium](https://www.browserstack.com/guide/verify-and-assert-in-selenium#:~:text=Difference%20between%20Assert%20and%20Verify%20in%20selenium&text=These%20assertions%20are%20used%20as,assert%20conditions%20are%20not%20met.)
5) [Difference between Assert and Verify](https://artoftesting.com/difference-between-assert-and-verify)
6) [What is the difference between Assert and Verify in Selenium?](https://www.tutorialspoint.com/what-is-the-difference-between-assert-and-verify-in-selenium)
