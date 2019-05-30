package com.bjwlxy.service;

import com.bjwlxy.mapper.EmploveeMapper;
import com.bjwlxy.pojo.Emplovee;
import com.bjwlxy.pojo.EmploveeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploveeService {

    @Autowired
    EmploveeMapper emploveeMapper;

    /**
     * 查询所有员工
     * @return
     */
    public List<Emplovee> getAll() {
        // TODO Auto-generated method stub
        return emploveeMapper.selectByExampleWithDept(null);
    }


    public int deleEmp(int empId) {
        int index= emploveeMapper.deleteByPrimaryKey(empId);
        return index;
    }

    public void saveEmp(Emplovee emplovee) {
        int i = emploveeMapper.insertSelective(emplovee);
    }

    /**
     * 检验用户名是否可用
     * @param empName
     * @return
     */
    public boolean checkUser(String empName) {
        EmploveeExample example = new EmploveeExample();
        EmploveeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = emploveeMapper.countByExample(example);
        return count == 0;
    }

    /**
     * 按照员工id查询员工
     * @param id
     * @return
     */
    public Emplovee getEmp(Integer id) {
        // TODO Auto-generated method stub
        Emplovee emplovee = emploveeMapper.selectByPrimaryKey(id);
        return emplovee;
    }

    /**
     * 员工更新
     * @param employee
     */
    public void updateEmp(Emplovee employee) {
        // TODO Auto-generated method stub
        emploveeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * 员工删除
     * @param id
     */
    public void deleteEmp(Integer id) {
        // TODO Auto-generated method stub
        emploveeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        // TODO Auto-generated method stub
        EmploveeExample example = new EmploveeExample();
        EmploveeExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andEmpIdIn(ids);
        emploveeMapper.deleteByExample(example);
    }
}
