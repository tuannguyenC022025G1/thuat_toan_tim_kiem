import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập số lượng phần tử và khởi tạo mảng
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Bước 2: Sắp xếp mảng
        Arrays.sort(array);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(array));

        // Nhập giá trị cần tìm
        System.out.print("Nhập giá trị cần tìm: ");
        int value = scanner.nextInt();

        // Gọi hàm tìm kiếm nhị phân
        int result = binarySearch(array, 0, array.length - 1, value);

        // In kết quả
        if (result == -1) {
            System.out.println("Không tìm thấy giá trị " + value + " trong mảng");
        } else {
            System.out.println("Tìm thấy giá trị " + value + " tại vị trí: " + result);
        }

        scanner.close();
    }

    // Bước 3-8: Hàm tìm kiếm nhị phân đệ quy
    public static int binarySearch(int[] array, int left, int right, int value) {
        // Điều kiện dừng: left > right
        if (left > right) {
            return -1;
        }

        // Bước 4: Tính middle
        int middle = (left + right) / 2;

        // Bước 5: Kiểm tra nếu tìm thấy giá trị
        if (array[middle] == value) {
            return middle;
        }

        // Bước 6: Nếu value lớn hơn, tìm ở nửa bên phải
        if (value > array[middle]) {
            return binarySearch(array, middle + 1, right, value);
        }

        // Bước 7: Nếu value nhỏ hơn, tìm ở nửa bên trái
        return binarySearch(array, left, middle - 1, value);
    }
}