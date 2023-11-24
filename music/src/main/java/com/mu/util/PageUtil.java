package com.mu.util;

public class PageUtil {
    public static final Integer DEFAULT_NUMBER = 15;//默认
    public static final Integer DEFAULT_CURRENT_PAGE = 1;//默认第几页

    /**
     * @param eachNumber  - 每页个数
     * @param currentPage - 当前页数
     * @return -计算结果
     */
    public static ResultPage calculate(Integer eachNumber, Integer currentPage) {
        ResultPage resultPage = new ResultPage();
        resultPage.setOffset(eachNumber * (currentPage - 1));
        resultPage.setLimit(eachNumber);
        return resultPage;
    }

    /**
     * 默认每页15个
     *
     * @param currentPage - 当前页数
     * @return -计算结果
     */
    public static ResultPage calculate(Integer currentPage) {
        ResultPage resultPage = new ResultPage();
        if (currentPage == null)
            currentPage = DEFAULT_CURRENT_PAGE;
        resultPage.setOffset(DEFAULT_NUMBER * (currentPage - 1));
        resultPage.setLimit(DEFAULT_NUMBER);
        return resultPage;
    }

    /**
     * 计算总页数
     *
     * @param eachNumber - 每页个数
     * @param total      - 总数
     * @return
     */
    public static Integer calculateNumber(Integer eachNumber, Integer total) {
        if (total % eachNumber != 0) {
            return total / eachNumber + 1;
        } else {
            return total / eachNumber;
        }
    }

    /**
     * 计算总页数
     * 默认每页个数
     *
     * @param total - 总数
     * @return
     */
    public static Integer calculateNumber(Integer total) {
        if (total % DEFAULT_NUMBER != 0) {
            return total / DEFAULT_NUMBER + 1;
        } else {
            return total / DEFAULT_NUMBER;
        }
    }

    /*public static void main(String[] args) {
        System.out.println(PageUtil.calculateNumber(15,16));
    }*/

}
