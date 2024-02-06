# Exercise 1
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

# Exercise 2
1
- Setelah menulis unit test, saya menjadi lebih yakin tentang kebenaran kode yang dibuat karena unit tes membantu menjamin fungsi berjalan dengan baik.
- Tidak ada aturan mengenai unit test minimum yang diperlukan, namun sebaiknya unit test mencakup skenario-skenario yang dapat terjadi pada fungsi tersebut.
- 100% Code coverage bukan berarti code tidak memiliki bug ataupun error, code coverage hanya memberi gambaran seberapa kode sumber telah diuji oleh test. Code coverage tidak menjelaskan apakah kode tersebut dapat menindak-lanjuti perilaku diluar dugaan atau kemungkinan-kemungkian error yang dapat terjadi.

2
- Clean code dapat berkurang karena terdapat pengulangan/duplikasi kode mengingat setup procedures dan instance variablesnya mirip atau sama dengan test suite sebelumnya.
- Menyederhanakan kode menggunakan prinsip "1 fungsi 1 tujuan", setiap fungsi memiliki kegunaannya masing-masing (seperti memisahkan prosedur setup ke dalam fungsi terpisah). Sehingga setiap fungsi memiliki kegunaan khusus dan dapat dipanggil setiap kali dibutuhkan.