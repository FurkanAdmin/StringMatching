Ödeve teslim tarihinden 3 gün önce ilgilenmeye başladık.

Evde bir adet boş bilgisyarımız var idi Furkan Cem Çelik ve Furkan Demir(ben) ödeve sunucu olarak kullandığımız kasada başladık.


algoritmaları yazarken şu hataları aldık

'''

int[] bTable = new int[65536];

Arrays.fill(bTable,-1);

for(int i = 0;i<pattern.length();i++)
    bTable[(int) pattern.charAt(i)] = Math.max(1,pattern.length() - i - 1);

'''

yukarıdaki gibi bir bad table oluşturduk fakat testlerin en fazla 14ünü geçebildik sorunu çözmek için her öğrenci gibi LLM'e sorduk ve yaptığımız algoritmanın Horspool denen bir şey olduğundan bahsetti.


Projede algoritmik kısımda Furkan Cem benden daha yetkin olduğu için bana ders anlatır gibi yazdığı algoritmaları anlattı ve preanalysis bölümünü daha çok ben yaptım.

Hata aldığımız bir diğer husus goodsuffix table tarafında idi, goodsuffix algoritması gerçekten bana insan üstü geldi, anlarken epey zorlandık.

Bu ödev boyer moore algoritması çok iyi şekilde kavramamı ve diğer algoritmaların birbine olan üstünlüğü hakkında ve algoritmaların hangi şartlar altında hangisnin daha verimli olacağını seçerken bu konuda vizyonum açıldı


Furkan Demir 22050111009 - Furkan Cem Çelik 23050151020