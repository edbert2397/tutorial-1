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