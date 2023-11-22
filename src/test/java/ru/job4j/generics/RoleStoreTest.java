package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("5", "Functional"));
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndGetRoleNameIsGeneral() {
        RoleStore store = new RoleStore();
        store.add(new Role("10", "General"));
        store.add(new Role("10", "Functional"));
        Role result = store.findById("10");
        assertThat(result.getRoleName()).isEqualTo("General");
    }

    @Test
    void whenReplaceThenRoleNameIsFunctional() {
        RoleStore store = new RoleStore();
        store.add(new Role("11", "General"));
        store.replace("11", new Role("11", "Functional"));
        Role result = store.findById("11");
        assertThat(result.getRoleName()).isEqualTo("Functional");
    }

    @Test
    void whenAddAndFindThenRoleNameIsFunctional() {
        RoleStore store = new RoleStore();
        store.add(new Role("11", "Functional"));
        Role result = store.findById("11");
        assertThat(result.getRoleName()).isEqualTo("Functional");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("11", "General"));
        store.replace("101", new Role("101", "Functional"));
        Role result = store.findById("11");
        assertThat(result.getRoleName()).isEqualTo("General");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "General"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleNameIsGeneral() {
        RoleStore store = new RoleStore();
        store.add(new Role("11", "General"));
        store.delete("10");
        Role result = store.findById("11");
        assertThat(result.getRoleName()).isEqualTo("General");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "General"));
        boolean result = store.replace("1", new Role("1", "Functional"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Functional"));
        boolean result = store.replace("10", new Role("10", "General"));
        assertThat(result).isFalse();
    }
}