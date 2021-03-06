package com.bokchoy.nowcode_community.mapper;

import com.bokchoy.nowcode_community.entity.LoginTicket;
import com.bokchoy.nowcode_community.entity.LoginTicketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LoginTicketMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    long countByExample(LoginTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    int deleteByExample(LoginTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    int insert(LoginTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    int insertSelective(LoginTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    List<LoginTicket> selectByExampleWithRowbounds(LoginTicketExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    List<LoginTicket> selectByExample(LoginTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    LoginTicket selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    int updateByExampleSelective(@Param("record") LoginTicket record, @Param("example") LoginTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    int updateByExample(@Param("record") LoginTicket record, @Param("example") LoginTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    int updateByPrimaryKeySelective(LoginTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_ticket
     *
     * @mbg.generated Tue Oct 26 16:34:13 CST 2021
     */
    int updateByPrimaryKey(LoginTicket record);
}