# JavaNangCao - Nhà Sách Minh Khai
# Đỗ Minh Tuấn

# Kết nối repo ở Remote(Github) với folder source code ở Local(Máy tính)
1. Tạo repo rồi copy nguyên cái đã có sẵn của Github 
2. Open git bash ở folder chứa code, chỗ mà mình muốn để tất các file or thư mục lên github
3. Paste thằng đã copy ở mục **1* mà nhận Enter 
4. Gõ lại ở GitBash lệnh **git remote -v or git status có ra thể thông tin là được**

# Push code lên khi tạo được repo và kết nối được remote
1. Open git bash ở folder chứa code (Cùng cấp với thư mục có thư mục **.git**)
2. Gõ lệnh **git add .** là add vào tất cả các file và thư mục đã có sự thay đổi
    1 Nếu muốn add file hay thư mục được chỉ định thì gõ **git add tenfile or tên thư mục**
3. Gõ lệnh **git commit -m "${message}"**, trong đó **${message}** là đoạn thông tin mô tả về commit(các file đã được), để nhìn vào biết cod đã thay đổi những gì
3. Gõ lệnh **git push** là đẩy code lên thôi
