# Spring Security Demo Projesi
## Proje Hakkında
Bu proje, Spring Security kullanarak güvenli bir web uygulaması geliştirmek için oluşturulmuş bir demo projesidir. Jakarta EE, Spring MVC ve Lombok teknolojilerini kullanmaktadır. Java SDK 21 üzerine inşa edilmiştir.
## Özellikler
- Güvenlik yapılandırması ile kimlik doğrulama ve yetkilendirme kontrolü
- Kimlik doğrulaması gerektiren ve herkese açık endpoint'lerin tanımlanması
- Form tabanlı giriş ve HTTP temel kimlik doğrulama desteği

## Güvenlik Yapılandırması
Proje, aşağıdaki endpoint'leri güvenlik kısıtlamalarıyla yapılandırmıştır:
### Kimlik Doğrulaması Gerektiren Endpoint'ler:
- - Kullanıcı hesap bilgileri `/myAccount`
- - Kullanıcı kart bilgileri `/myCards`
- - Kullanıcı bakiye bilgileri `/myBalance`
- - Kullanıcı kredi bilgileri `/myLoans`

### Herkes Tarafından Erişilebilen Endpoint'ler:
- - İletişim sayfası `/contact`
- - Hata sayfası `/error`
- - Duyuru sayfası `/notice`

## Kurulum
### Gereksinimler
- Java 21 veya üzeri
- Maven veya Gradle
- IntelliJ IDEA (önerilen)

### Adımlar
1. Projeyi klonlayın:
``` bash
git clone https://github.com/kullanici-adi/spring-security-demo.git
```
1. Proje dizinine gidin:
``` bash
cd spring-security-demo
```
1. Projeyi derleyin:
``` bash
./mvnw clean install
```
1. Uygulamayı çalıştırın:
``` bash
./mvnw spring-boot:run
```
1. Tarayıcıda aşağıdaki URL'i açın:
``` 
http://localhost:8080
```
## Kullanım
1. Herkes tarafından erişilebilen sayfaları görüntülemek için:
    - [http://localhost:8080/contact](http://localhost:8080/contact)
    - [http://localhost:8080/notice](http://localhost:8080/notice)

2. Korumalı sayfalara erişmek için önce kimlik doğrulaması yapmalısınız:
    - [http://localhost:8080/myAccount](http://localhost:8080/myAccount)
    - [http://localhost:8080/myCards](http://localhost:8080/myCards)
    - [http://localhost:8080/myBalance](http://localhost:8080/myBalance)
    - [http://localhost:8080/myLoans](http://localhost:8080/myLoans)

## Katkıda Bulunma
1. Bu repository'yi fork edin
2. Feature branch'i oluşturun (`git checkout -b feature/yeni-ozellik`)
3. Değişikliklerinizi commit edin (`git commit -am 'Yeni özellik ekle'`)
4. Branch'inizi push edin (`git push origin feature/yeni-ozellik`)
5. Pull Request oluşturun

## İletişim
Yusuf Ülkü - [ysf_metu@ehotmail.com](mailto:ysf_metu@ehotmail..com)
