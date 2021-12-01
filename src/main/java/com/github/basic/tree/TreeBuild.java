package com.github.basic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MarkShen
 * @since 2021/11/30
 */
public class TreeBuild {

    /**
     * 生成测试数据
     *
     * @return
     */
    static List<Menu> generateData() {
        // 数据准备
        List<Menu> menuList = new ArrayList<>();
        Menu m1 = new Menu(1, "Logical Database Design", 0);
        Menu m2 = new Menu(2, "Jaywalking", 1);
        Menu m3 = new Menu(3, "Objective", 2);
        Menu m4 = new Menu(4, "Antipattern", 2);
        Menu m5 = new Menu(6, "Native Trees", 1);
        Menu m6 = new Menu(7, "Solution", 6);
        Menu m7 = new Menu(8, "Legitimate Uses of the Antipattern", 6);
        menuList.add(m1);
        menuList.add(m2);
        menuList.add(m3);
        menuList.add(m4);
        menuList.add(m5);
        menuList.add(m6);
        menuList.add(m7);
        return menuList;
    }

    /**
     * 构建树
     * 
     * @param allData
     * @param pId
     * @param root
     */
    static void buildTree01(List<Menu> allData, int pId, Menu root) {
        if (allData.stream().filter(m -> m.getPid() == pId).findAny().isPresent()) {
            root.setSubMenuList(allData.stream().filter(m -> m.getPid() == pId).collect(Collectors.toList()));
            for (Menu menu : root.getSubMenuList()) {
                if (allData.stream().filter(m -> m.getPid() == menu.getId()).findAny().isPresent()) {
                    buildTree01(allData, menu.getId(), menu);
                } else {
                    menu.setSubMenuList(new ArrayList<>());
                }
            }
        }
    }

    /**
     * 遍历树
     * 
     * @param menu
     */
    private static void iterateTree(Menu menu) {
        if (menu != null) {
            System.out.println("id=" + menu.getId() + ", name=" + menu.getName() + ", pid=" + menu.getPid());
            if (menu.getSubMenuList() != null && !menu.getSubMenuList().isEmpty()) {
                for (Menu me : menu.getSubMenuList()) {
                    iterateTree(me);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Menu> menuList = generateData();
        Menu menu = menuList.stream().filter(m -> m.getPid() == 0).findFirst().get();
        buildTree01(menuList, menu.getId(), menu);
        System.out.println(menu);
        System.out.println("iterate menu...");
        iterateTree(menu);
    }
}

class Menu {
    private Integer id;
    private String name;
    private Integer pid;
    List<Menu> subMenuList;

    public Menu() {}

    public Menu(Integer id, String name, Integer pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Menu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<Menu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", name='" + name + '\'' + ", pid=" + pid + ", subMenuList=" + subMenuList + '}';
    }
}
