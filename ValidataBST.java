public class ValidataBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    // if node is root, max and min are null
    private boolean isValidBST(TreeNode root, Integer max, Integer min) {
        // 1. check if the current node is null
        // yes then return true;
        if (root == null) {
            return true;
        }
        // 2.all left children nodes' keys are less than the node's key
        // set the node's key as max
        // if there is one of the left children' key is greater than max
        // return false
        if (max != null && root.val >= max) {
            return false;
        }
        // 3. all right children nodes' keys are greater than the node's key
        // set the node's key as min
        // if there is one of the right children' key is less than min
        // return false
        if (min != null && root.val <= min) {
            return false;
        }
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    public static void main(String[] args) {
        ValidataBST valid = new ValidataBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(valid.isValidBST(root));

    }
}
