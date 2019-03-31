package tag.string;

/**
 * @ClassName optimalDivision
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/28 12:21
 * @Version 1.0
 */
public class optimalDivision {public String optimalDivision(int[] nums) {
    if(nums.length == 1){
        return Integer.toString(nums[0]);
    }else if(nums.length == 2){
        return nums[0] + "/" + nums[1];
    }
    StringBuilder res = new StringBuilder();
    res.append(nums[0] + "/(");
    for (int i = 1; i < nums.length; i++) {
        res.append(nums[i]+"/");
    }
    res.deleteCharAt(res.length() - 1);
    res.append(")");
    return res.toString();
}
}
