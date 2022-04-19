class RoundRobin():
    def processData(self, no_of_processes):
        process_data = []
        for i in range(no_of_processes):
            temporary = []
            process_id = int(input("Nhap ID Tien Trinh: "))
            arrival_time = int(input(f"Nhap Thoi Gian Xuat Hien Tien Trinh {process_id}: "))
            burst_time = int(input(f"Nhap Thoi Gian Thuc Hien Tien Trinh {process_id}: "))
            temporary.extend([process_id, arrival_time, burst_time])
            process_data.append(temporary)
        time_slice = int(input("Nhap quantum: "))
        RoundRobin.schedulingProcess(self, process_data, time_slice)

    def schedulingProcess(self, process_data, time_slice):
        mang_thuchien = []
        start_time =[]
        end_time = []

        while 1:
            process_data.sort(key=lambda x: x[1])
            for i in range(len(process_data)):
                # print(process_data[i])
                if len(mang_thuchien) == 0:
                    print("Nhanh a")
                    mang_thuchien.append(process_data[i])
                    start_time.append(mang_thuchien[i][1])

                    if mang_thuchien[i][2] >= time_slice:
                        end_time.append(time_slice)
                    else:
                        end_time.append(mang_thuchien[i][2])
                    mang_thuchien[0][2] -= (end_time[i - 1] - start_time[i - 1])
                    # print(mang_thuchien, start_time, end_time)

                else:
                    print("Nhanh b")
                    if len(mang_thuchien) < len(process_data):
                        if process_data[i][1] <= end_time[i-1]:
                            mang_thuchien = mang_thuchien[1:] + mang_thuchien[:1]
                            mang_thuchien[0][2] -= (end_time[i-1] - start_time[i-1])

                            start_time.append(end_time[i-1])
                            if mang_thuchien[0][2] >= time_slice:
                                end_time.append(end_time[i-1] + time_slice)
                            else:
                                end_time.append(end_time[i-1] + mang_thuchien[0][2])
                            mang_thuchien.append(process_data[i])
                        else:
                            break
                    else:
                        break

                    # mang_thuchien = mang_thuchien[1:]+mang_thuchien[:0]
                print(mang_thuchien, start_time, end_time)
                if mang_thuchien[0][2] == 0:
                    mang_thuchien.remove(mang_thuchien[0])
                    print(mang_thuchien, start_time, end_time)


if __name__ == "__main__":
    no_of_processes = int(input("Nhap So Luong Tien Trinh: "))
    rr = RoundRobin()
    rr.processData(no_of_processes)