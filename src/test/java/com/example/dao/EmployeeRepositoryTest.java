package com.example.dao;

import com.example.model.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepositoryTest implements EmployeeRepository{

    private static List<Employee> emp = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return Collections.unmodifiableList(emp);
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Employee> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Employee> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Employee> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Employee> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Employee getOne(String s) {
        return null;
    }

    @Override
    public Employee getById(String s) {
        return null;
    }

    @Override
    public <S extends Employee> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employee> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Employee> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Employee, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    public Employee save(Employee e){
        emp.add(e);
        return e;
    }

    public List<Employee> findAll(List<Employee> list){
        return Collections.unmodifiableList(list);
    }

}