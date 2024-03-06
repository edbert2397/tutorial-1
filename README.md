# Tutorial 4

## 1. Refleksi terhadap TTD Flow
Saya baru pertama kali menggunakan Test-Driven Development (TDD) flow, saya merasa bahwa cara ini sangat berguna. Saya melihat bahwa TDD flow membantu saya dalam mengevaluasi apakah yang dilakukan sudah benar correctness dan maintainability. Saya mengalami kesulitan dalam membuat testing terlebih dahulu. Saya juga kesulitan memeriksa testnya .

# Tutorial 3
## 1.Prinsip yang diaplikasikan
- ### Single Responsibility Principle
  Menghapus "extends ProductController" pada CarController karena kedua class tersebut memiiliki fungsi yang saling berbeda, sehingga tidak ada gunanya CarController meng-extend ProductController
- ### Dependancy Inversion
  Mengganti tipe data CarServiceImpl menjadi CarService pada file CarController. Hal ini dilakukan agar CarController bergantung pada abstract class nya "CarService" dan bukan "CarServiceImpl", sehingga perubahan pada CarServiceImpl tidak berdapak langsung pada CarController.
- ### Interface Segregation
    Kedua interface hanya berhubungan masing-masing ke 1 objek saja yaitu ProductService ke Product dan CarService ke Car. Kedua hal tersebut berupa interface class yang saling terpisah sehingga service yang menggunakannya hanya membutuhkan salah satu diantaranya dan bukan keduanya. Hal ini menyebabkan class yang mengimplement interface tersebut, mengimplementasikan method yang dibutuhkan saja
- ### Open Close
    Class dan funtion yang dibuat dapat di extend dan ditambah implementasinya tanpa harus mengubah codebase. Contohnya adalah ProductService sebagai base dan ProductServiceImpl yang akan mengimplementasikan method-method tersebut yang akan digunakan, tetapi masih juga dapat ditambahkan method tambahan.
## 2. Keunggulan mengimplementasikan prinsip SOLID
- ### meningkatkan readibility code
    Code yang terlalu kompleks akan mempersulit pembaca untuk membaca code tersebut. Alangkah lebih mudah jika hal kompleks tersebut dipecah menjadi bagian yang lebih sederhana sehingga yang membacanya pun tidak bingung saat membaca code tersebut. 
- ### Tambahan fitur dalam code
    Open Closed principle, method khusus baru dapat ditambahkan tanpa perlu mengubah code base yang sudah ada 
- ### Perubahan pada satu bagian kode tidak merusak kode pada bagian lain
    Dependency inversion principle, menggunakan tipe data interface daripada concrete implementation dari interface tersebut. Hal tersebut dilakukan agar kita tidak perlu mengubah CarController secara langsung jika ada perubahan pada CarServiceImpl
## 3. Kerugian tidak mengimplementasikan SOLID
- Kode akan lebih sulit dibaca sehingga akan membutuhkan waktu yang lebih lama agar Pembaca mengerti maksud code tersebut
- Jika melakukan modifikasi pada suatu code, harus memastikan bahwa perubahan code tersebut tidak membuat bagian lain menjadi rusak dan tidak bekerja. 
- Kode juga akan lebih kotor dan berantakan karena ada bagian yang melakukan berbagai macam sekaligus. Misal pada saat CarController dan ProductController dgabungkan
# Tutorial 2
## 1.List _Quality Code Issues_ yang di fix:
- ### Rename function name menjadi _camel case naming convention_:
    Sebelumnya ada beberapa function bawaan yang menggunakan _snake case naming convention_, kemudian saya mengubahnya menjadi mengikuti _camel case naming convention_.
- ### Mengubah modifier dari class interface service:
    Saya mengubah modifier yang sebelumnya berupa public menjadi default tanpa public modifier. 
- ### Mengubah import dari annotation *:
    Sebelumnya salah satu import pada productController saya seperti ini,
    
    `import org.springframework.web.bind.annotation.*`
    
    Kemudian, saya mengubahnya menjadi seperti ini:

    `import org.springframework.web.bind.annotation.GetMapping;`
  
    `import org.springframework.web.bind.annotation.ModelAttribute;`
  
    `import org.springframework.web.bind.annotation.PostMapping;`
    
    `import org.springframework.web.bind.annotation.RequestMapping;`
  
    `import org.springframework.web.bind.annotation.PathVariable;`

## 2. Implementasi kode sekarang sudah memenuhi CI/CD:
- Menurut saya, implementasi sekarang sudah mengimplementasikan Ci/CD. Dengan menggunakan github workflows, setiap kali terdapat push pada suatu branch, maka proses testing dan deployment akan otomatis terjadi. Setiap kali terjadi push, kode tersebut akan diuji dengan ci.yml dan kemudian diperiksa kebenaran (bukan logika) dari kode tersebut dengan PMD. Setelah itu, kode dapat di merge ke branch main, kemudian akan otomatis ter-deploy ke Paas Koyeb dengan action scorecard.yml. Hal tersebut membentuk CI/CD workflow pada Software Development Lifecycle.
# Tutorial 1
## Exercise 1
## Implementasi Prinsip _Clean code_:
### _Meaningful Names_:
1. menggunakan nama variabel yang sudah jelas maksudnya, seperti `productId` yang berarti id produk, kemudian juga `productQuantity` yang berarti kuantitas produk.
2. menggunakan nama fungsi yang sudah jelas maksudnya, seperti `create` yang berarti membuat produk, ataupun `delete` yang berarti menghapus produk.
### fungsi
1. prinsip "_Function should do one thing_" fungsi yang fokus pada 1 kegunaan saja.
2. prinsip "_Function have no side effects_", yaitu seperti fungsi `create`,`edit`,`delete` yang tidak memiliki efek samping lain.
### komentar
1. prinsip "_Don't comment bad code, rewrite it_", karena nama variabel, nama fungsi, dan alurnya sudah jelas sehingga tidak membutuhkan komentar.

## Improve
1. Id produk yang belum di-_generate_ menyebabkan produk tersebut tidak bisa di-edit, sehingga saya langsung generate Id produk tersebut dengan random UUID ketika suatu produk dibuat.
2. Kedepannya, diperlukan sistem autentikasi dan autorisasi agar akses pengguna dapat diimpelementasikan dengan lebih baik.

## Exercise 2
1
- Setelah menulis unit test, saya menjadi lebih yakin tentang kebenaran kode yang dibuat karena unit tes membantu menjamin fungsi berjalan dengan baik.
- Tidak ada aturan mengenai unit test minimum yang diperlukan, namun sebaiknya unit test mencakup skenario-skenario yang dapat terjadi pada fungsi tersebut.
- 100% Code coverage bukan berarti code tidak memiliki bug ataupun error, code coverage hanya memberi gambaran seberapa kode sumber telah diuji oleh test. Code coverage tidak menjelaskan apakah kode tersebut dapat menindak-lanjuti perilaku diluar dugaan atau kemungkinan-kemungkian error yang dapat terjadi.

2
- Clean code dapat berkurang karena terdapat pengulangan/duplikasi kode mengingat setup procedures dan instance variablesnya mirip atau sama dengan test suite sebelumnya.
- Menyederhanakan kode menggunakan prinsip "1 fungsi 1 tujuan", setiap fungsi memiliki kegunaannya masing-masing (seperti memisahkan prosedur setup ke dalam fungsi terpisah). Sehingga setiap fungsi memiliki kegunaan khusus dan dapat dipanggil setiap kali dibutuhkan.