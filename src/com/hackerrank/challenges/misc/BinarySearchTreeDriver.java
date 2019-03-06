package com.hackerrank.challenges.misc;

public class BinarySearchTreeDriver {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.put("f", "eff");
        tree.put("c", "sea");
        tree.put("a", "aye");
        tree.put("e", "eee");
        tree.put("i", "eye");
        tree.put("h", "aitch");
        tree.put("z", "zed");

        String str = (String) tree.get("i"); // str will equal "eye"
        System.out.println(str);

        tree.put("i", "eye updated");

        str = (String) tree.get("i"); // str will equal "eye updated"
        System.out.println(str);
    }

    public static class BinarySearchTree {
        private BinarySearchTreeNode root;

        public void put(String key, Object value) {
            if (root == null) {
                root = new BinarySearchTreeNode(key, value);
            } else {
                root.put(key, value);
            }
        }

        public Object get(String key) {
            return root == null ? null : root.get(key);
        }
    }

    public static class BinarySearchTreeNode {
        private String key;
        private Object value;
        private BinarySearchTreeNode left, right;

        public BinarySearchTreeNode(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        //if key not found in BinarySearchTree then it is added. If key already exists then that node's value
        //is updated.
        public void put(String key, Object value) {
            if (key.compareTo(this.key) < 0) {
                if (left != null) {
                    left.put(key, value);
                } else {
                    left = new BinarySearchTreeNode(key, value);
                }
            } else if (key.compareTo(this.key) > 0) {
                if (right != null) {
                    right.put(key, value);
                } else {
                    right = new BinarySearchTreeNode(key, value);
                }
            } else {
                //update this one
                this.value = value;
            }
        }

        //find Node with given key and return it's value
        public Object get(String key) {
            if (this.key.equals(key)) {
                return value;
            }

            if (key.compareTo(this.key) < 0) {
                return left == null ? null : left.get(key);
            } else {
                return right == null ? null : right.get(key);
            }
        }
    }
}
