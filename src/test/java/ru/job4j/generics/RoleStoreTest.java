package ru.job4j.generics;


import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {
    @Test
    public void whenReplaceRole() {
        RoleStore roleStore = new RoleStore();
        Role one = new Role("Admin");
        Role two = new Role("User");
        Role three = new Role("Manager");
        roleStore.add(one);
        roleStore.add(two);
        roleStore.replace("Admin", three);
        assertThat(roleStore.findById("User"), is(two));
        assertThat(roleStore.findById("Admin") , is(three));
    }

    @Test
    public void whenDeleteUserThenUserIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("netuser"));
        roleStore.delete("netuser");
        Role result = roleStore.findById("netuser");
        assertNull(result);
    }

}