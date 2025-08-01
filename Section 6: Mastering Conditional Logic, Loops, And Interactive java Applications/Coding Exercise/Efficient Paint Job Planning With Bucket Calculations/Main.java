class PaintJob{
    // Suggested code may be subject to a license. Learn more: ~LicenseLog:934241173.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:1855357108.
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){
        if(width <=0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0){
            return -1;
        }
        return (int)Math.ceil((width * height) / areaPerBucket) - extraBuckets;
    }
    
    public static int getBucketCount(double width, double height, double areaPerBucket){
        if(width <=0 || height <= 0 || areaPerBucket <= 0){
            return -1;
        }
        return (int)Math.ceil((width * height) / areaPerBucket);
    }
    
    public static int getBucketCount(double area, double areaPerBucket){
        if(area <=0 || areaPerBucket <= 0){
            return -1;
        }
        return (int)Math.ceil(area/areaPerBucket);
    }

}
public class Main {
    public static void main(String[] args) {
        // Suggested code may be subject to a license. Learn more: ~LicenseLog:2726966429.

        System.out.println(PaintJob.getBucketCount(-3.4, 2.1, 1.5, 2)); // -1
        System.out.println(PaintJob.getBucketCount(3.4, 2.1, 1.5, 2));  // 3
        System.out.println(PaintJob.getBucketCount(2.75, 3.25, 2.5, 1)); // 3

        System.out.println(PaintJob.getBucketCount(-3.4, 2.1, 1.5));  // -1
        System.out.println(PaintJob.getBucketCount(3.4, 2.1, 1.5));   // 5
        System.out.println(PaintJob.getBucketCount(7.25, 4.3, 2.35)); // 14

        System.out.println(PaintJob.getBucketCount(3.26, 0.75));     // 5
        System.out.println(PaintJob.getBucketCount(-3.26, 0.75));    // -1
        System.out.println(PaintJob.getBucketCount(2.8, 0.75));      // 4
        
    }
}
